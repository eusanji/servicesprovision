package com.servicesprovision.model.entity;

import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Client extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    @NotEmpty(message = "{field.name.required}")
    private String name;

    @Column(nullable = false, length = 11)
    @NotNull(message = "{field.cpf.required}")
    @CPF(message = "{field.cpf.invalid}")
    private String cpf;

}
