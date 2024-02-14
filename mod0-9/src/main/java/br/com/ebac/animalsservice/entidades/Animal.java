    package br.com.ebac.animalsservice.entidades;

    import jakarta.persistence.*;

    import java.sql.Date;

    // AnimalEntity.java
    @Entity
    public class Animal {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name="id", nullable = false)
        private Integer id;

        @Column(nullable = false)
        private String nomeProvisorio;
        @Column(nullable = false)
        private Integer idadeEstimada;
        @Column(nullable = false)
        private String raca;
        @Column(nullable = false)
        private Date dataEntrada;

        private Date dataAdocao;
        @Column(nullable = false)
        private String condicoesChegada;

        @ManyToOne
        @JoinColumn(name = "collaborator_id")
        private Collaborator collaborator;

        private Date dataObito;
        @Column(nullable = false)
        private String porte;

        @Column(nullable = false)
        private String especie;



        public Integer getId(){
            return id;
        }

        public String getNomeProvisorio() {
            return nomeProvisorio;
        }

        public void setNomeProvisorio(String nomeProvisorio) {
            this.nomeProvisorio = nomeProvisorio;
        }

        public Integer getIdadeEstimada() {
            return idadeEstimada;
        }

        public void setIdadeEstimada(Integer idadeEstimada) {
            this.idadeEstimada = idadeEstimada;
        }

        public String getRaca() {
            return raca;
        }

        public void setRaca(String raca) {
            this.raca = raca;
        }

        public Date getDataEntrada() {
            return dataEntrada;
        }

        public void setDataEntrada(Date dataEntrada) {
            this.dataEntrada = dataEntrada;
        }

        public Date getDataAdocao() {
            return dataAdocao;
        }

        public void setDataAdocao(Date dataAdocao) {
            this.dataAdocao = dataAdocao;
        }

        public String getCondicoesChegada() {
            return condicoesChegada;
        }

        public void setCondicoesChegada(String condicoesChegada) {
            this.condicoesChegada = condicoesChegada;
        }


        public Collaborator getCollaborator() {
            return collaborator;
        }

        public void setCollaborator(Collaborator collaborator) {
            this.collaborator = collaborator;
        }

        public Date getDataObito() {
            return dataObito;
        }

        public void setDataObito(Date dataObito) {
            this.dataObito = dataObito;
        }

        public String getPorte() {
            return porte;
        }

        public void setPorte(String porte) {
            this.porte = porte;
        }

        public String getEspecie() {
            return especie;
        }

        public void setEspecie(String especie) {
            this.especie = especie;
        }
    }
