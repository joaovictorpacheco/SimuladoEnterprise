package domain;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_EQUIPAMENTO",uniqueConstraints = @UniqueConstraint(name = "NM_TIPODEACAO",columnNames = "NM_TIPODEACAO"))
public class TipoDeAcao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPODEACAO")
    @SequenceGenerator(name="SQ_TIPODEACAO", sequenceName = "SQ_TIPODEACAO")
    @Column(name = "ID_TIPODEACAO")
    private long id;

    @Column(name= "NM_TIPODEACAO")
    private String nome;

    public TipoDeAcao() {
    }

    public TipoDeAcao(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public TipoDeAcao setId(long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public TipoDeAcao setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("TipoDeAcao{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
