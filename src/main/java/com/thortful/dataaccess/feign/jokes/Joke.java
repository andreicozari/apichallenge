package com.thortful.dataaccess.feign.jokes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Builder
public class Joke {

  private String id;
  private String type;
  private String setup;
  private String punchline;

}