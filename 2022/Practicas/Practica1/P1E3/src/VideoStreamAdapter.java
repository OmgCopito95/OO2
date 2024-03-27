public class VideoStreamAdapter implements Media{

    private VideoStream videoStream;

    public VideoStreamAdapter(){
        this.videoStream = new VideoStream();
    }

    @Override
    public void play() {
        videoStream.reproduce();
    }
    
}
