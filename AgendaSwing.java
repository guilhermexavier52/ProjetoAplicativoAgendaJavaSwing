package agendaSwing;

	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
   

public class AgendaSwing extends JFrame implements ActionListener {


	private static final long serialVersionUID = 1437691323751241193L;
	private JTextField txtNome;
	private JTextField txtTelefone;
	private JTextField txtEmail;
	private JTextArea txtAreaContatos;
	private JButton btnAdicionar;
	private JButton btnLimpar;
	private ArrayList<Contato> contatos;
	
public AgendaSwing() {
	
	setTitle("AGENDA");
	setSize(400, 400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(new BorderLayout());
	setBackground(Color.RED);
	contatos = new ArrayList<>();

JPanel painelFormulario = new JPanel(new GridLayout(4, 2));

	painelFormulario.add(new JLabel("Nome:"));
	txtNome = new JTextField();
	painelFormulario.add(txtNome);
	painelFormulario.add(new JLabel("Telefone:"));

	txtTelefone = new JTextField();
	painelFormulario.add(txtTelefone);
	painelFormulario.add(new JLabel("Email:"));
	txtEmail = new JTextField();
	painelFormulario.add(txtEmail);

JPanel painelBotoes = new JPanel(new FlowLayout());
	btnAdicionar = new JButton("Adicionar");
	btnAdicionar.addActionListener(this);
	btnLimpar = new JButton("Limpar");
	btnLimpar.addActionListener(this);
	painelBotoes.add(btnAdicionar);
	painelBotoes.add(btnLimpar);

	txtAreaContatos = new JTextArea();
	txtAreaContatos.setEditable(false);

	add(painelFormulario, BorderLayout.NORTH);
	add(painelBotoes, BorderLayout.CENTER);
	add(new JScrollPane(txtAreaContatos), BorderLayout.SOUTH);

	setVisible(true);
	}


	@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource() == btnAdicionar) {

	String nome = txtNome.getText();
	String telefone = txtTelefone.getText();
	String email = txtEmail.getText();
	Contato contato = new Contato(nome, telefone, email);
	
	contatos.add(contato);
	atualizarListaContatos();
	limparCampos();

	} else if (e.getSource() == btnLimpar) {
	limparCampos();
	}
	}

private void atualizarListaContatos() {
	txtAreaContatos.setText("");
	for (Contato contato : contatos) {
	txtAreaContatos.append(contato.toString() + "\n");
	}
	}

private void limparCampos() {
	txtNome.setText("");
	txtTelefone.setText("");
	txtEmail.setText("");
	txtNome.requestFocus();
	}

public static void main(String[] args) {
	SwingUtilities.invokeLater(new Runnable() {

	@Override
	public void run() {
	new AgendaSwing();
	}
	});
	}
	}


class Contato {
	private String nome;
	private String telefone;
	private String email;

public Contato(String nome, String telefone, String email) {
	this.nome = nome;
	this.telefone = telefone;
	this.email = email;
	}

	@Override
public String toString() {
	return "Nome: " + nome + ", Telefone: " + telefone + ", Email: " + email;

	}

}


