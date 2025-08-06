
    set client_min_messages = WARNING;

    alter table if exists abbonamento_attivita 
       drop constraint if exists FK853iwjge5sco7nac3v8pvs72v;

    alter table if exists abbonamento_attivita 
       drop constraint if exists FK7slwjgyb7wchv5gnm07g9m6v1;

    alter table if exists abbonamento_socio 
       drop constraint if exists FKnocg3o0qcq1tningp2l4lmk6r;

    alter table if exists certificato_medico 
       drop constraint if exists FKr17u6bpruq0epjt5g760mbe7c;

    drop table if exists abbonamento_attivita cascade;

    drop table if exists abbonamento_socio cascade;

    drop table if exists attivita cascade;

    drop table if exists certificato_medico cascade;

    drop table if exists messaggi_sistema cascade;

    drop table if exists socio cascade;
