create table tags
(
    id  bigint auto_increment
        primary key,
    name  varchar(255) not null
);

CREATE TABLE user_tags
(
    user_id bigint NOT NULL,
    tag_id bigint NOT NULL,
    CONSTRAINT user_tags_pk PRIMARY KEY (user_id, tag_id),
    CONSTRAINT user_id_fk FOREIGN KEY (user_id) REFERENCES store.users(id) ON DELETE CASCADE,
    CONSTRAINT tag_id_fk FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
);