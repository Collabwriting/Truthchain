package dev.truthchain.api.entities;

import jakarta.persistence.*;
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

    @Column(columnDefinition = "NVARCHAR")
    private String title;

    @Column(columnDefinition = "NVARCHAR")
    private String content;
    private String type;

    @Column(columnDefinition = "NVARCHAR")
    private String url;
    private Date createdAt;

    private String ual;
    private String account;
    private String signature;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private StatusError error;

    public enum Status {
        PENDING,
        CREATED,
        VERIFIED,
        PUBLISHING,
        PUBLISHED,
        FAILED
    }

    public enum StatusError {
        NOT_VERIFIABLE,
        NOT_SAVED_TO_DKG,
    }

}
