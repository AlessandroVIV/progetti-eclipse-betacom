
    alter table abbonamento_socio 
       drop 
       foreign key FKnocg3o0qcq1tningp2l4lmk6r;

    alter table certificato_medico 
       drop 
       foreign key FKr17u6bpruq0epjt5g760mbe7c;

    drop table if exists abbonamento_socio;

    drop table if exists certificato_medico;

    drop table if exists socio;
