package dhbw.pojo.result.detail;



public class DetailResult {
    private String title;
    private String info;
    private int popularity;

    public DetailResult(String title, String info, int popularity) {
        this.title = title;
        this.info = info;
        this.popularity = popularity;
    }

    public DetailResult() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
    public int getPopularity(){
        return popularity;
    }
    
    public void setPopularity(int popularity){
        this.popularity = popularity;
    }
    
}

