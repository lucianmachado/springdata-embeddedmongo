package io.lucian;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashMap;
import java.util.List;

/**
 * Created by lucian on 07/10/2017.
 */
@Document(collection = "ies")
public class IES {
    @Id
    public String id;
    public String nome;
    public String filantropica;
    public String uf;
    public String bairro;
    public String cep;
    public String situacao;
    public String igc_continuo;
    public String confessional;
    public String categoria_administrativa;
    public String site;
    public String ano_igc;
    public String fax;
    public String conceito_institucional_ci;
    public List<HashMap<String,String>> campus;
    public List<HashMap<String,String>> atos;
    public List<HashMap<String,String>> processos;
    public String municipio;
    public String igc;
    public String ead;
    public String reitor_dirigente;
    public String codigo_ies;
    public String numero_endereco;
    public String comunitaria;
    public String complemento;
    public String organizacao;
    public String ano_conceito_institucional_ci;
    public String endereco;
    public String telefone;
    public String email;
    public String ano_igc_continuo;

    public HashMap<String,String> mantenedora;
    //TODO Mapear campus oferecidos
    @Field("cursos_posgraduacao")
    public List<HashMap<String,String>> cursosPosGraduacao;
    @Field("cursos_graduacao")
    public List<HashMap<String,String>> cursosGraduacao;
}
