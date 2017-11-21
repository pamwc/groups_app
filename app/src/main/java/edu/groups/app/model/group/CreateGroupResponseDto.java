
package edu.groups.app.model.group;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateGroupResponseDto {

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("joinCode")
    @Expose
    private String joinCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoinCode() {
        return joinCode;
    }

    public void setJoinCode(String joinCode) {
        this.joinCode = joinCode;
    }

}
