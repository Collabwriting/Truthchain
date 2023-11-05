package dev.truthchain.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class Snippet {

    @Id
    @Column(name = "id" , columnDefinition="uniqueidentifier")
    private UUID id;

    private String title;
    private String content;
    private String type;
    private String url;

    private Date createdAt;
}
