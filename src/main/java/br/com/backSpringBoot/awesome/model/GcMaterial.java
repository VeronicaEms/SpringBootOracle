package br.com.backSpringBoot.awesome.model;

import br.com.jdbcpersistence.annotation.Column;
import br.com.jdbcpersistence.annotation.Id;
import br.com.jdbcpersistence.annotation.Temporal;
import br.com.jdbcpersistence.annotation.Table;
import br.com.jdbcpersistence.annotation.Form;
import br.com.jdbcpersistence.annotation.TypeField;
import java.util.Date;
import java.io.Serializable;

/**
 * Classe gerada atraves do Bean generator \o/
 *
 * @version 1.0.2
 * @autor ortega
 *
 */
@Table(name = "GC_MATERIAL")
//@Sequence(name = "SGC_MATERIAL", column = "COD_MATERIAL")
@Form(formWidth = "370px")
public class GcMaterial implements Serializable {

    @Id
    @Column(name = "COD_MATERIAL", caption = "SYS.GC_MATERIAL.COD_MATERIAL", precision = 40)
    private String codMaterial;
    @Column(name = "DESCRICAO", caption = "SYS.GC_MATERIAL.DESCRICAO", precision = 250)
    private String descricao;
    @Column(name = "MODELO", caption = "SYS.GC_MATERIAL.MODELO", precision = 20)
    private String modelo;
    @Column(name = "MARCA", caption = "SYS.GC_MATERIAL.MARCA", precision = 20)
    private String marca;
    @Column(name = "APLICACAO", caption = "SYS.GC_MATERIAL.APLICACAO", precision = 40)
    private String aplicacao;
    @Column(name = "COMPLEMENTO", caption = "SYS.GC_MATERIAL.COMPLEMENTO", precision = 250)
    private String complemento;
    @Column(name = "COD_SIT_MATERIAL", caption = "SYS.GC_MATERIAL.COD_SIT_MATERIAL", precision = 1)
    private String codSitMaterial;
    @Column(name = "IND_CONTROLE_ESTOQ", caption = "SYS.GC_MATERIAL.IND_CONTROLE_ESTOQ", precision = 1)
    private String indControleEstoq;
    @Column(name = "COD_OPCIONAL", caption = "SYS.GC_MATERIAL.COD_OPCIONAL", precision = 40)
    private String codOpcional;
    @Column(name = "COD_GRUPO_SEPAR", caption = "SYS.GC_MATERIAL.COD_GRUPO_SEPAR", precision = 3)
    private String codGrupoSepar;
    @Column(name = "COD_GRUPO_COMPRA", caption = "SYS.GC_MATERIAL.COD_GRUPO_COMPRA", precision = 5)
    private String codGrupoCompra;
    @Column(name = "COD_TIPO_MATERIAL", caption = "SYS.GC_MATERIAL.COD_TIPO_MATERIAL", precision = 1)
    private String codTipoMaterial;
    @Column(name = "COD_UNIDADE", caption = "SYS.GC_MATERIAL.COD_UNIDADE", precision = 3)
    private String codUnidade;
    @Column(name = "COD_FAMILIA", caption = "SYS.GC_MATERIAL.COD_FAMILIA", precision = 5)
    private String codFamilia;
    @Column(name = "COD_CONTA_CONTABIL", caption = "SYS.GC_MATERIAL.COD_CONTA_CONTABIL", precision = 15)
    private String codContaContabil;
    @Column(name = "COD_SIT_TRIBUT", caption = "SYS.GC_MATERIAL.COD_SIT_TRIBUT", precision = 3)
    private String codSitTribut;
    @Column(name = "COD_CLASSIF_FISCAL", caption = "SYS.GC_MATERIAL.COD_CLASSIF_FISCAL", precision = 10)
    private String codClassifFiscal;
    @Column(name = "VOLUME", caption = "SYS.GC_MATERIAL.VOLUME", precision = 21)
    private Double volume;
    @Column(name = "PESO", caption = "SYS.GC_MATERIAL.PESO", precision = 21)
    private Double peso;
    @Column(name = "COD_EMBALAGEM", caption = "SYS.GC_MATERIAL.COD_EMBALAGEM", precision = 10)
    private String codEmbalagem;
    @Column(name = "ID_IPI_PAUTA_FISCAL", caption = "SYS.GC_MATERIAL.ID_IPI_PAUTA_FISCAL", precision = 3)
    private Integer idIpiPautaFiscal;
    @Column(name = "ID_CLASSIF_ITEM_SUBST_TRIBUT", caption = "SYS.GC_MATERIAL.ID_CLASSIF_ITEM_SUBST_TRIBUT", precision = 7)
    private Integer idClassifItemSubstTribut;
    @Column(name = "COD_CATEGORIA_MATERIAL", caption = "SYS.GC_MATERIAL.COD_CATEGORIA_MATERIAL", precision = 5)
    private String codCategoriaMaterial;
    @Column(name = "COD_CONTA_CONTABIL_DESP", caption = "SYS.GC_MATERIAL.COD_CONTA_CONTABIL_DESP", precision = 15)
    private String codContaContabilDesp;
    @Column(name = "COD_CONTA_CONTABIL_CUSTO", caption = "SYS.GC_MATERIAL.COD_CONTA_CONTABIL_CUSTO", precision = 15)
    private String codContaContabilCusto;
    @Column(name = "IND_UTILIZA_DECIMAL", caption = "SYS.GC_MATERIAL.IND_UTILIZA_DECIMAL", precision = 1)
    private String indUtilizaDecimal;
    @Column(name = "IND_TIPO_LOCALIZACAO", caption = "SYS.GC_MATERIAL.IND_TIPO_LOCALIZACAO", precision = 1)
    private String indTipoLocalizacao;
    @Column(name = "IND_ICMS_ST_PAUTA", caption = "SYS.GC_MATERIAL.IND_ICMS_ST_PAUTA", precision = 1)
    private String indIcmsStPauta;
    @Column(name = "COD_UNIDADE_CONVERSAO", caption = "SYS.GC_MATERIAL.COD_UNIDADE_CONVERSAO", precision = 3)
    private String codUnidadeConversao;
    @Column(name = "PCT_ALIQUOTA_IPI", caption = "SYS.GC_MATERIAL.PCT_ALIQUOTA_IPI", precision = 7)
    private Double pctAliquotaIpi;
    @Column(name = "COD_CEST", caption = "SYS.GC_MATERIAL.COD_CEST", precision = 7)
    private String codCest;
    @Temporal
    @Column(name = "DT_CADASTRO", caption = "SYS.GC_MATERIAL.DT_CADASTRO", typeField = TypeField.TEMPORAL)
    private Date dtCadastro;
    @Column(name = "COD_CLASSIF_MATERIAL", caption = "SYS.GC_MATERIAL.COD_CLASSIF_MATERIAL", precision = 5)
    private String codClassifMaterial;

    public String getCodMaterial() {
        return codMaterial;
    }

    public void setCodMaterial(String codMaterial) {
        this.codMaterial = codMaterial;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCodSitMaterial() {
        return codSitMaterial;
    }

    public void setCodSitMaterial(String codSitMaterial) {
        this.codSitMaterial = codSitMaterial;
    }

    public String getIndControleEstoq() {
        return indControleEstoq;
    }

    public void setIndControleEstoq(String indControleEstoq) {
        this.indControleEstoq = indControleEstoq;
    }

    public String getCodOpcional() {
        return codOpcional;
    }

    public void setCodOpcional(String codOpcional) {
        this.codOpcional = codOpcional;
    }

    public String getCodGrupoSepar() {
        return codGrupoSepar;
    }

    public void setCodGrupoSepar(String codGrupoSepar) {
        this.codGrupoSepar = codGrupoSepar;
    }

    public String getCodGrupoCompra() {
        return codGrupoCompra;
    }

    public void setCodGrupoCompra(String codGrupoCompra) {
        this.codGrupoCompra = codGrupoCompra;
    }

    public String getCodTipoMaterial() {
        return codTipoMaterial;
    }

    public void setCodTipoMaterial(String codTipoMaterial) {
        this.codTipoMaterial = codTipoMaterial;
    }

    public String getCodUnidade() {
        return codUnidade;
    }

    public void setCodUnidade(String codUnidade) {
        this.codUnidade = codUnidade;
    }

    public String getCodFamilia() {
        return codFamilia;
    }

    public void setCodFamilia(String codFamilia) {
        this.codFamilia = codFamilia;
    }

    public String getCodContaContabil() {
        return codContaContabil;
    }

    public void setCodContaContabil(String codContaContabil) {
        this.codContaContabil = codContaContabil;
    }

    public String getCodSitTribut() {
        return codSitTribut;
    }

    public void setCodSitTribut(String codSitTribut) {
        this.codSitTribut = codSitTribut;
    }

    public String getCodClassifFiscal() {
        return codClassifFiscal;
    }

    public void setCodClassifFiscal(String codClassifFiscal) {
        this.codClassifFiscal = codClassifFiscal;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    ;

	public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    ;

	public String getCodEmbalagem() {
        return codEmbalagem;
    }

    public void setCodEmbalagem(String codEmbalagem) {
        this.codEmbalagem = codEmbalagem;
    }

    public Integer getIdIpiPautaFiscal() {
        return idIpiPautaFiscal;
    }

    public void setIdIpiPautaFiscal(Integer idIpiPautaFiscal) {
        this.idIpiPautaFiscal = idIpiPautaFiscal;
    }

    public Integer getIdClassifItemSubstTribut() {
        return idClassifItemSubstTribut;
    }

    public void setIdClassifItemSubstTribut(Integer idClassifItemSubstTribut) {
        this.idClassifItemSubstTribut = idClassifItemSubstTribut;
    }

    public String getCodCategoriaMaterial() {
        return codCategoriaMaterial;
    }

    public void setCodCategoriaMaterial(String codCategoriaMaterial) {
        this.codCategoriaMaterial = codCategoriaMaterial;
    }

    public String getCodContaContabilDesp() {
        return codContaContabilDesp;
    }

    public void setCodContaContabilDesp(String codContaContabilDesp) {
        this.codContaContabilDesp = codContaContabilDesp;
    }

    public String getCodContaContabilCusto() {
        return codContaContabilCusto;
    }

    public void setCodContaContabilCusto(String codContaContabilCusto) {
        this.codContaContabilCusto = codContaContabilCusto;
    }

    public String getIndUtilizaDecimal() {
        return indUtilizaDecimal;
    }

    public void setIndUtilizaDecimal(String indUtilizaDecimal) {
        this.indUtilizaDecimal = indUtilizaDecimal;
    }

    public String getIndTipoLocalizacao() {
        return indTipoLocalizacao;
    }

    public void setIndTipoLocalizacao(String indTipoLocalizacao) {
        this.indTipoLocalizacao = indTipoLocalizacao;
    }

    public String getIndIcmsStPauta() {
        return indIcmsStPauta;
    }

    public void setIndIcmsStPauta(String indIcmsStPauta) {
        this.indIcmsStPauta = indIcmsStPauta;
    }

    public String getCodUnidadeConversao() {
        return codUnidadeConversao;
    }

    public void setCodUnidadeConversao(String codUnidadeConversao) {
        this.codUnidadeConversao = codUnidadeConversao;
    }

    public Double getPctAliquotaIpi() {
        return pctAliquotaIpi;
    }

    public void setPctAliquotaIpi(Double pctAliquotaIpi) {
        this.pctAliquotaIpi = pctAliquotaIpi;
    }

    ;

	public String getCodCest() {
        return codCest;
    }

    public void setCodCest(String codCest) {
        this.codCest = codCest;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public String getCodClassifMaterial() {
        return codClassifMaterial;
    }

    public void setCodClassifMaterial(String codClassifMaterial) {
        this.codClassifMaterial = codClassifMaterial;
    }

}
