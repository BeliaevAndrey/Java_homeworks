package classes.partClasses;

public class VideoCard extends Part{
    private String vCardParams;

    public VideoCard(String vCardParams) {
        super("Video Card");
        this.vCardParams = vCardParams;
    }

    public String getVCardParams() {
        return vCardParams;
    }

    @Override
    public String toString() {
        return String.format("%s, Video Card. %s",  this.brand, vCardParams);
    }
}
