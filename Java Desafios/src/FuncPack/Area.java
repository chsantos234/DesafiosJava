package FuncPack;

public class Area{
	String codigo;
	String nome;
	int NumFuncionarios = 0;
	
	public Area(String codigo,String nome) {
		this.codigo = codigo;
		this.nome = nome;}
	
	public String getCodigo() {
		return codigo;}

	public String getNome() {
		return nome;}

	public int getNumFuncionarios() {
		return NumFuncionarios;}

	public void AdicionarFuncionario() {
		NumFuncionarios += 1; }
	
}