package br.com.hoyler.apps.java.demojavafxspring.tools;

public enum ViewFXML {
    LOGIN("Login", "br.com.hoyler.apps.java.demojavafxspring.gui");

    private final String FileName;
    private final String FilePackage;

    ViewFXML(String FileName, String FilePackage) {
        this.FileName = FileName;
        this.FilePackage = FilePackage;
    }
    private String getFileName(){
        return(FileName);
    };
    private String getFilePackage(){
        return(FilePackage);
    };

    public String getFilePatch(){
        String result = String.format("/%s/%s.fxml", (getFilePackage().replace(".", "/")), (getFileName()));
        return (result);
    }

}
