package edu.alumno.adria.dwes_futbol_rest.model.db;

import java.io.Serializable;
import java.sql.Date;

import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "jornadas")
public class JornadaDb implements Serializable{
    @Id
    @Range(min = 0, max = 38, message = "El número debe de estar entre 0 y 38")
    private Long num;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
}