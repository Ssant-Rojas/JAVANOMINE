package co.edu.unbosque.view;

public class ViewFacade {
private VentanaPrincipal vP;
public ViewFacade() {
	// TODO Auto-generated constructor stub
	vP = new VentanaPrincipal();
}
public VentanaPrincipal getvP() {
	return vP;
}
public void setvP(VentanaPrincipal vP) {
	this.vP = vP;
}

}
