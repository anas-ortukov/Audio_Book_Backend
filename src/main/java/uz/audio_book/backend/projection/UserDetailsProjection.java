package uz.audio_book.backend.projection;

import java.util.UUID;

public interface UserDetailsProjection {

    UUID getId();
    String getDisplayName();
    String getEmail();
    String getBirthDate();

}
