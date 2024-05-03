package Material;

public class Lesson {
    private int lesson_num;
    private String text;
    private String video_url;
    private Chapter chapter;
    private Course course;

    public Lesson(String text, String url, Chapter c) {
        this.text = text;
        this.video_url = url;
        this.chapter = c;
        course = c.getCourse();
        try {
            lesson_num = c.getLessons().indexOf(c.getLessons().getLast()) + 1;
        } catch (Exception e) {
            lesson_num = 1;
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVideo_url() {
        try {
            return video_url;
        } catch (NullPointerException e) {
            System.out.println("Video URL is not initialized");
            return null;
        }
    }

    public void setVideo_url(String video_url) {
        try {
            if (video_url == null || video_url.isEmpty()) {
                throw new IllegalArgumentException("Video URL cannot be null or empty");
            }
            this.video_url = video_url;
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid argument for video URL");
        }
    }

    public Chapter getChapter() {
        return chapter;
    }

    public Course getCourse() {
        return course;
    }

    public int getLesson_num() {
        return lesson_num;
    }

    @Override
    public String toString() {
        return ("Lesson: " + this.lesson_num + "\n" +
                "TEXT: " + this.text + "\n" +
                "URL: " + this.video_url + "\n" +
                "Course: " + this.getCourse() + "\n" +
                "Chapter: " + this.chapter + "\n" +

                "");
    }
}
