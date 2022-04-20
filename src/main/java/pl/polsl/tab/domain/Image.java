package pl.polsl.tab.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Image.
 */
@Entity
@Table(name = "image")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "image", nullable = false)
    private byte[] image;

    @NotNull
    @Column(name = "image_content_type", nullable = false)
    private String imageContentType;

    @Size(max = 150)
    @Column(name = "description", length = 150)
    private String description;

    @NotNull
    @Column(name = "image_size", nullable = false)
    private String imageSize;

    @NotNull
    @Column(name = "format", nullable = false)
    private String format;

    @NotNull
    @Column(name = "date_of_create", nullable = false)
    private LocalDate dateOfCreate;

    @ManyToOne
    private User user;

    @ManyToMany(mappedBy = "images")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "folder", "user", "images", "parentFolders" }, allowSetters = true)
    private Set<Folder> folders = new HashSet<>();

    @ManyToMany(mappedBy = "images")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "images" }, allowSetters = true)
    private Set<Category> categories = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Image id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Image name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return this.image;
    }

    public Image image(byte[] image) {
        this.setImage(image);
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return this.imageContentType;
    }

    public Image imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getDescription() {
        return this.description;
    }

    public Image description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageSize() {
        return this.imageSize;
    }

    public Image imageSize(String imageSize) {
        this.setImageSize(imageSize);
        return this;
    }

    public void setImageSize(String imageSize) {
        this.imageSize = imageSize;
    }

    public String getFormat() {
        return this.format;
    }

    public Image format(String format) {
        this.setFormat(format);
        return this;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public LocalDate getDateOfCreate() {
        return this.dateOfCreate;
    }

    public Image dateOfCreate(LocalDate dateOfCreate) {
        this.setDateOfCreate(dateOfCreate);
        return this;
    }

    public void setDateOfCreate(LocalDate dateOfCreate) {
        this.dateOfCreate = dateOfCreate;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image user(User user) {
        this.setUser(user);
        return this;
    }

    public Set<Folder> getFolders() {
        return this.folders;
    }

    public void setFolders(Set<Folder> folders) {
        if (this.folders != null) {
            this.folders.forEach(i -> i.removeImage(this));
        }
        if (folders != null) {
            folders.forEach(i -> i.addImage(this));
        }
        this.folders = folders;
    }

    public Image folders(Set<Folder> folders) {
        this.setFolders(folders);
        return this;
    }

    public Image addFolder(Folder folder) {
        this.folders.add(folder);
        folder.getImages().add(this);
        return this;
    }

    public Image removeFolder(Folder folder) {
        this.folders.remove(folder);
        folder.getImages().remove(this);
        return this;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        if (this.categories != null) {
            this.categories.forEach(i -> i.removeImage(this));
        }
        if (categories != null) {
            categories.forEach(i -> i.addImage(this));
        }
        this.categories = categories;
    }

    public Image categories(Set<Category> categories) {
        this.setCategories(categories);
        return this;
    }

    public Image addCategory(Category category) {
        this.categories.add(category);
        category.getImages().add(this);
        return this;
    }

    public Image removeCategory(Category category) {
        this.categories.remove(category);
        category.getImages().remove(this);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Image)) {
            return false;
        }
        return id != null && id.equals(((Image) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Image{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            ", description='" + getDescription() + "'" +
            ", imageSize='" + getImageSize() + "'" +
            ", format='" + getFormat() + "'" +
            ", dateOfCreate='" + getDateOfCreate() + "'" +
            "}";
    }
}
