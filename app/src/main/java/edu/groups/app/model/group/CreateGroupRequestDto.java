package edu.groups.app.model.group;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Kamil on 01/12/2017.
 */

@Data
@RequiredArgsConstructor
public class CreateGroupRequestDto {
    private final String groupName;
}
