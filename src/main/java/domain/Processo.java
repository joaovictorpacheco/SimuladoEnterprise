package domain;

import jakarta.persistence.*;

import java.time.LocalDate;
//Não pode ter processo com o mesmo numero por isso a unique constraint
@Entity
@Table(name = "TB_PROCESSO",uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_PROCESSO",columnNames = "NM_PROCESSO")
    }
)
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PROCESSO")
    @SequenceGenerator(name="SQ_PROCESSO", sequenceName = "SQ_PROCESSO")
    @Column(name = "ID_PROCESSO")
    private long id;

    @Column(name= "NR_PROCESSO")
    private String numero;

    @Column(name= "DT_DISTRIBUICAO")
    private LocalDate dataDeDistribuicao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(name = "ID_TIPODEACAO", referencedColumnName = "ID_TIPODEACAO",
            foreignKey = @ForeignKey(name = "FK_PROC_TP_ACAO", value = ConstraintMode.CONSTRAINT))
    private TipoDeAcao tipoDeAcao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH})
    @JoinColumn(name = "ID_ADVOGADO", referencedColumnName = "ID_ADVOGADO",
            foreignKey = @ForeignKey(name = "FK_PROC_ADVOGADO", value = ConstraintMode.CONSTRAINT))
    private Advogado advogado;

    @Column(name= "PRO_BONO")
    private boolean proBono;


    public Processo() {
    }

    public Processo(long id, String numero, LocalDate dataDeDistribuicao, TipoDeAcao tipoDeAcao, Advogado advogado, boolean proBono) {
        this.id = id;
        this.numero = numero;
        this.dataDeDistribuicao = dataDeDistribuicao;
        this.tipoDeAcao = tipoDeAcao;
        this.advogado = advogado;
        this.proBono = proBono;
    }

    public long getId() {
        return id;
    }

    public Processo setId(long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Processo setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public LocalDate getDataDeDistribuicao() {
        return dataDeDistribuicao;
    }

    public Processo setDataDeDistribuicao(LocalDate dataDeDistribuicao) {
        this.dataDeDistribuicao = dataDeDistribuicao;
        return this;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }

    public Processo setTipoDeAcao(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
        return this;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Processo setAdvogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public boolean isProBono() {
        return proBono;
    }

    public Processo setProBono(boolean proBono) {
        this.proBono = proBono;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Processo{");
        sb.append("id=").append(id);
        sb.append(", numero='").append(numero).append('\'');
        sb.append(", dataDeDistribuicao=").append(dataDeDistribuicao);
        sb.append(", tipoDeAcao=").append(tipoDeAcao);
        sb.append(", advogado=").append(advogado);
        sb.append(", proBono=").append(proBono);
        sb.append('}');
        return sb.toString();
    }
}
