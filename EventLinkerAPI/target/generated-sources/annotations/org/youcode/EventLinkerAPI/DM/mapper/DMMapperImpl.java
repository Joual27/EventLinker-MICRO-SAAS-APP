package org.youcode.EventLinkerAPI.DM.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import org.youcode.EventLinkerAPI.DM.DM;
import org.youcode.EventLinkerAPI.DM.DTOs.DmResponseDTO;
import org.youcode.EventLinkerAPI.user.DTOs.EmbeddedUserDTO;
import org.youcode.EventLinkerAPI.user.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-01T14:42:16+0000",
    comments = "version: 1.6.2, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class DMMapperImpl implements DMMapper {

    @Override
    public DmResponseDTO toResponseDTO(DM entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        List<EmbeddedUserDTO> users = null;

        id = entity.getId();
        users = userSetToEmbeddedUserDTOList( entity.getUsers() );

        DmResponseDTO dmResponseDTO = new DmResponseDTO( id, users );

        return dmResponseDTO;
    }

    protected EmbeddedUserDTO userToEmbeddedUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        String username = null;

        username = user.getUsername();

        EmbeddedUserDTO embeddedUserDTO = new EmbeddedUserDTO( username );

        return embeddedUserDTO;
    }

    protected List<EmbeddedUserDTO> userSetToEmbeddedUserDTOList(Set<User> set) {
        if ( set == null ) {
            return null;
        }

        List<EmbeddedUserDTO> list = new ArrayList<EmbeddedUserDTO>( set.size() );
        for ( User user : set ) {
            list.add( userToEmbeddedUserDTO( user ) );
        }

        return list;
    }
}
