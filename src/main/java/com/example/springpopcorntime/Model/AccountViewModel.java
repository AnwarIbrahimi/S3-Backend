package com.example.springpopcorntime.Model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AccountViewModel {
        public Long id;
        public String firstName ;
        public String lastName ;
        public String  emailId;
        public String  password;
        public boolean logged;
}
