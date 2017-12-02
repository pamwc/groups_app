package edu.groups.app.model.group;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/**
 * Created by Kamil on 30/11/2017.
 */

@Data
@RequiredArgsConstructor
public class JoinGroupRequestDto {
    private final String code;
}
