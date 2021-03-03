package pl.pacwa.newsapi.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ArticleDto {

    @NotNull(message = "id cannot be null.")
    @Min(value = 1, message = "id must be greater than 1.")
    private Long id;
    @NotBlank(message = "title connot be blank.")
    @NotNull(message = "title connet be null.")
    private String title;

    @NotBlank(message = "url image connot be blank.")
    @NotNull(message = "url image connet be null.")
    private String urlToImage;

    @NotBlank(message = "description connot be blank.")
    @NotNull(message = "description connet be null.")
    private String description;

    @NotBlank(message = "published connot be blank.")
    @NotNull(message = "published connet be null.")
    private String publishedAt;

    public ArticleDto() {
    }

    public ArticleDto(Long id, String title, String urlToImage, String description, String publishedAt) {
        this.id = id;
        this.title = title;
        this.urlToImage = urlToImage;
        this.description = description;
        this.publishedAt = publishedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                '}';
    }
}
