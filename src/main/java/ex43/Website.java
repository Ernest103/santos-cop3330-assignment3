package ex43;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Website {

    //Object Variables
    private String siteName;
    private String author;
    private String css;
    private String jsc;
    private final String root;
    boolean files_created;

    public Website(String root, String siteName, String author, String css, String jsc) {
        this.root = root;
        this.siteName = siteName;
        this.author = author;
        this.css = css;
        this.jsc = jsc;
        files_created = false;
    }


    //Initialization method where all the necessary files are created
    //  Returns false if the process fails at any point
    public boolean initWebsite()
    {
        this.files_created = true;

        String createDir = String.format("%s%s", this.root, this.siteName);
        String html = String.format("%s/index.html", createDir);
        File ofp = new File(createDir);


        //Checks if it was able to create a directory
        //  Then it creates the index.html file
        if(ofp.mkdir()) {
            try {
                ofp = new File(html);
                ofp.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                files_created = false;
            }
        }


        //Creates The css folder only if specified to
        if(css.equals("y"))
        {
            createDir = String.format("%s%s/css", this.root, siteName);
            ofp = new File(createDir);
            if(!ofp.mkdir())
                files_created = false;
        }

        //Creates the js folder only if specified to
        if(jsc.equals("y"))
        {
            createDir = String.format("%s%s/js", this.root, siteName);
            ofp = new File(createDir);
            if(!ofp.mkdir())
                files_created = false;
        }


        return files_created;
    }

    //Pre: index that html must have been created
    //Post: Initializes the contents of the html file to a basic template
    public String initHTML()
    {
        if(files_created)
        {
            try {
                String file_path = String.format("%s%s/index.html", this.root, this.siteName);
                File ofp = new File(file_path);
                FileWriter writer = new FileWriter(ofp.getPath());
                String file_content = String.format("<!doctype html>\n" +
                        "<html>\n" +
                        "<head>\n" +
                        "<title>%s</title>\n" +
                        "<meta Author=\"%s\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "Content goes here.\n" +
                        "</body>\n" +
                        "</html>", this.siteName, this.author);

                writer.write(file_content);
                writer.close();
                return file_path;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    //Pre: All files must have been created previous to calling this function
    //Post: Displays all the files and dirs that were created for the website
    public void display()
    {
        if(files_created)
        {
            System.out.printf("Created %s%s\n", this.root, this.siteName);
            System.out.printf("Created %s%s/index.html\n", this.root, this.siteName);
            if(jsc.equals("y"))
                System.out.printf("Created %sjs/\n", this.root);
            if(css.equals("y"))
                System.out.printf("Created %scss/\n", this.root);
        }
    }

    /*----------Getters and Setters------------*/
    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCss() {
        return css;
    }

    public void setCss(String css) {
        this.css = css;
    }

    public String getJsc() {
        return jsc;
    }

    public void setJsc(String jsc) {
        this.jsc = jsc;
    }
}
