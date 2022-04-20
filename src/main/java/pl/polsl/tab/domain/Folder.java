package pl.polsl.tab.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Folder.
 */
@Entity
@Table(name = "folder")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Folder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Size(max = 150)
    @Column(name = "description", length = 150)
    private String description;

    @ManyToOne
    @JsonIgnoreProperties(value = { "folder", "user", "images", "parentFolders" }, allowSetters = true)
    private Folder folder;

    @ManyToOne
    private User user;

    @ManyToMany
    @JoinTable(
        name = "rel_folder__image",
        joinColumns = @JoinColumn(name = "folder_id"),
        inverseJoinColumns = @JoinColumn(name = "image_id")
    )
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "user", "folders", "categories" }, allowSetters = true)
    private Set<Image> images = new HashSet<>();

    @OneToMany(mappedBy = "folder")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "folder", "user", "images", "parentFolders" }, allowSetters = true)
    private Set<Folder> parentFolders = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Folder id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Folder name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public Folder description(String description) {
        this.setDescription(description);
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Folder getFolder() {
        return this.folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
    }

    public Folder folder(Folder folder) {
        this.setFolder(folder);
        return this;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Folder user(User user) {
        this.setUser(user);
        return this;
    }

    public Set<Image> getImages() {
        return this.images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Folder images(Set<Image> images) {
        this.setImages(images);
        return this;
    }

    public Folder addImage(Image image) {
        this.images.add(image);
        image.getFolders().add(this);
        return this;
    }

    public Folder removeImage(Image image) {
        this.images.remove(image);
        image.getFolders().remove(this);
        return this;
    }

    public Set<Folder> getParentFolders() {
        return this.parentFolders;
    }

    public void setParentFolders(Set<Folder> folders) {
        if (this.parentFolders != null) {
            this.parentFolders.forEach(i -> i.setFolder(null));
        }
        if (folders != null) {
            folders.forEach(i -> i.setFolder(this));
        }
        this.parentFolders = folders;
    }

    public Folder parentFolders(Set<Folder> folders) {
        this.setParentFolders(folders);
        return this;
    }

    public Folder addParentFolder(Folder folder) {
        this.parentFolders.add(folder);
        folder.setFolder(this);
        return this;
    }

    public Folder removeParentFolder(Folder folder) {
        this.parentFolders.remove(folder);
        folder.setFolder(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Folder)) {
            return false;
        }
        return id != null && id.equals(((Folder) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Folder{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
