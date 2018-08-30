package br.senai.sp.cfp127.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import br.senai.sp.cfp127.cliente.Cliente;
import java.awt.TextArea;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

public class FrmCliente extends JFrame{
	
	private JPanel painelTitulo;
	private JPanel painelDados;
	private TitledBorder bordaDados;
	private TitledBorder bordaResultado;
	
	//Declaracoes dos labels da tela
	private JLabel lblTitulo,
				   lblIcone,
				   lblNome,
				   lblPeso,
				   lblAltura,
				   lblIdade,
				   lblNivelAtiv,
				   lblImc,
				  // lblImcL,
				   lblTmb,
				   lblTmbL,
				   lblFcm,
				   lblFcmL;
	
	//Declara��o dos campos de texto
	private JTextField txtNome,
					   txtPeso,
					   txtAltura,
					   txtIdade;
	
	// Declara��o Dos R�dios
	private JRadioButton rdFeminino,
						 rdMasculino;
	
	//Declara��o do combo
	private JComboBox cdAtividade;
	
	private Color cinza = new Color(195, 195, 195);
	private Color preto = new Color ( 0, 0, 0);
	private Font minhaFonte = new Font("Arial", 1 , 20);
	private ImageIcon iconeTitulo;
	private ImageIcon iconeCalc;
	
	private JButton btCalcular;
	private JPanel DetalhesCliente;
	private JPanel panelSexo;
	private JPanel painelEnderecoCliente;
	private JTextField txtCidade;
	private JTextField textField;
	private JTextField txtemail;
	private JTextField txtTelefone;
	private JLabel lblImcl;
	private JLabel lblLogradouro;
	private JTextField txtLogra;
	private JPanel panelClientes;
	private JTable table;
	
	public FrmCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gym32.png")));
		
		setTitle("Cadastro de Cliente");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setResizable(false);
		getContentPane().setLayout(null);
		

		//** LABEL Titulo
		lblTitulo = new JLabel("Academia boa forma");
		lblTitulo.setBounds(50, 10 , 300, 30);
		lblTitulo.setFont(minhaFonte);
		
		//** Label Icone
		lblIcone = new JLabel("");
		lblIcone.setBounds(5, 5 , 40, 40);
		iconeTitulo = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/gym32.png"));
		lblIcone.setIcon(iconeTitulo);
		
		//** PAINEL TITULO
		painelTitulo = new JPanel();
		painelTitulo.setLayout(null);
		painelTitulo.setBackground(cinza);
		painelTitulo.setBounds(0, 0, 600, 50);
		//** Adicionando os elementos no painel
		painelTitulo.add(lblTitulo);
		painelTitulo.add(lblIcone);
		bordaDados = new TitledBorder("Dados do Cliente:");
		bordaDados.setTitleColor(preto);
		
		//** grupoRadio junto do sexo
		ButtonGroup grupoRadio = new ButtonGroup();
		
		String[] nivelAtividade = {"Sedent�rio","Levemente Ativo","Moderadamente ativo", "Bastante ativo", "Muito ativo" };
		System.out.println(nivelAtividade[4]);
		iconeCalc = new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/calc24.png"));
		bordaResultado = new TitledBorder("Resultados do Cliente:");
		bordaResultado.setTitleColor(preto);
		
		getContentPane().add(painelTitulo);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 50, 594, 521);
		getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Lista de Clientes", null, panel, null);
		panel.setLayout(null);
		
		panelClientes = new JPanel();
		panelClientes.setBackground(new Color(255, 255, 255));
		panelClientes.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelClientes.setBounds(0, 0, 589, 482);
		panel.add(panelClientes);
		panelClientes.setLayout(null);
		
		JScrollPane scrollTabela = new JScrollPane();
		scrollTabela.setBounds(10, 22, 569, 249);
		panelClientes.add(scrollTabela);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Nome", "Email"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(177);
		table.getColumnModel().getColumn(2).setResizable(false);
		scrollTabela.setViewportView(table);
		
		JButton btnNovo = new JButton("");
		btnNovo.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/novo64.png")));
		btnNovo.setToolTipText("Novo\r\n");
		btnNovo.setBounds(10, 387, 89, 73);
		panelClientes.add(btnNovo);
		
		JButton btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/editar48.png")));
		btnEditar.setToolTipText("Editar");
		btnEditar.setBounds(135, 387, 89, 73);
		panelClientes.add(btnEditar);
		
		JButton btnDeletar = new JButton("");
		btnDeletar.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/Deletar48.png")));
		btnDeletar.setToolTipText("Deletar\r\n");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnDeletar.setBounds(261, 387, 89, 73);
		panelClientes.add(btnDeletar);
		
		JButton btnSair = new JButton("");
		btnSair.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/sair48.png")));
		btnSair.setToolTipText("Sair");
		btnSair.setBounds(490, 387, 89, 73);
		panelClientes.add(btnSair);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Detalhes do Cliente", null, panel_1, null);
		panel_1.setLayout(null);
		
		DetalhesCliente = new JPanel();
		DetalhesCliente.setBackground(new Color(240,240,240));
		DetalhesCliente.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		DetalhesCliente.setBounds(10, 11, 569, 471);
		panel_1.add(DetalhesCliente);
		DetalhesCliente.setLayout(null);
						
						// Painel de dados
						painelDados = new JPanel();
						painelDados.setBounds(10, 11, 549, 242);
						DetalhesCliente.add(painelDados);
						painelDados.setBackground(new Color(240,240,240));
						painelDados.setLayout(null);
						painelDados.setBorder(bordaDados);
						
						//**Nome
						lblNome = new JLabel("Nome:");
						lblNome.setBounds(25, 40, 100, 20);
						
						txtNome = new JTextField();
						txtNome.setBackground(new Color(255, 250, 205));
						txtNome.setBounds(25, 59, 164, 30);
						
						//** Peso 
						lblPeso = new JLabel("Peso:");
						lblPeso.setBounds(25, 100, 40, 20);
						
						txtPeso = new JTextField();
						txtPeso.setBounds(25, 118, 58, 25);
						

	
						//** Altura
						lblAltura = new JLabel("Altura:");
						lblAltura.setBounds(93, 100, 45, 20);
						
						txtAltura = new JTextField();
						txtAltura.setBounds(93, 118, 60, 25);
						
						//** Idade
						lblIdade = new JLabel("Data Nasc:");
						lblIdade.setBounds(199, 40, 72, 20);
						
						txtIdade = new JTextField();
						txtIdade.setBounds(199, 59, 72, 27);
						
								
									
						
								
								//Nivel de atividade
								
								lblNivelAtiv = new JLabel("Nivel de Atividade:");
								lblNivelAtiv.setBounds(184, 100, 105, 20);
								
								cdAtividade = new JComboBox(nivelAtividade);
								cdAtividade.setBounds(184, 118, 170, 30);
								
										
								
										
										painelDados.add(lblNome);
										painelDados.add(txtNome);
										painelDados.add(lblPeso);
										painelDados.add(txtPeso);
										painelDados.add(lblAltura);
										painelDados.add(txtAltura);
										painelDados.add(lblNivelAtiv);
										painelDados.add(cdAtividade);
										painelDados.add(lblIdade);
										painelDados.add(txtIdade);
										
										panelSexo = new JPanel();
										panelSexo.setBorder(new TitledBorder(null, "Sexo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
										panelSexo.setBackground(new Color(240, 240, 240));
										panelSexo.setBounds(411, 43, 100, 92);
										painelDados.add(panelSexo);
										panelSexo.setLayout(null);
										
										rdFeminino = new JRadioButton("Feminino");
										rdFeminino.setBounds(10, 24, 84, 30);
										panelSexo.add(rdFeminino);
										rdFeminino.setBackground(new Color(240, 240, 240));
										grupoRadio.add(rdFeminino);
										
										rdMasculino = new JRadioButton("Masculino");
										rdMasculino.setBounds(10, 57, 84, 30);
										panelSexo.add(rdMasculino);
										rdMasculino.setBackground(new Color(240, 240, 240));
										grupoRadio.add(rdMasculino);
										
										btCalcular = new JButton("");
										btCalcular.setBounds(184, 169, 170, 46);
										painelDados.add(btCalcular);
										btCalcular.setToolTipText("Salvar");
										btCalcular.setIcon(new ImageIcon(FrmCliente.class.getResource("/br/senai/sp/cfp127/imagens/Salvar32.png")));
										
										btCalcular.addActionListener(new ActionListener() {
											
											@Override
											public void actionPerformed(ActionEvent e) {
												Cliente cliente = new Cliente();
												cliente.setNome(txtNome.getText());
												cliente.setPeso(Double.parseDouble(txtPeso.getText()));
												cliente.setAltura(Double.parseDouble(txtAltura.getText()));
												cliente.setIdade(Integer.parseInt(txtIdade.getText()));
												cliente.setNivelAtividade(cdAtividade.getSelectedIndex()+1);
												
												if(rdFeminino.isSelected()) {
													cliente.setSexo('F');
												}else if (rdMasculino.isSelected()) {
													cliente.setSexo('M');
													
												}else {
													JOptionPane.showMessageDialog(null, "Para de ser burro");
												}
												
												lblImcl.setText(cliente.getImc());
												lblTmbL.setText(String.valueOf(cliente.getTmb()));
												lblFcmL.setText(String.valueOf(cliente.getFcm()));
											}
										});
										
										painelEnderecoCliente = new JPanel();
										painelEnderecoCliente.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Endere\u00E7o do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
										painelEnderecoCliente.setBackground(new Color(240, 240, 240));
										painelEnderecoCliente.setBounds(20, 264, 370, 196);
										DetalhesCliente.add(painelEnderecoCliente);
										painelEnderecoCliente.setLayout(null);
										
										JLabel lblCidade = new JLabel("Cidade:");
										lblCidade.setBounds(10, 24, 66, 18);
										painelEnderecoCliente.add(lblCidade);
										
										txtCidade = new JTextField();
										txtCidade.setBounds(10, 41, 137, 27);
										painelEnderecoCliente.add(txtCidade);
										txtCidade.setColumns(10);
										
										JLabel lblBairro = new JLabel("Bairro:");
										lblBairro.setBounds(177, 26, 46, 14);
										painelEnderecoCliente.add(lblBairro);
										
										textField = new JTextField();
										textField.setBounds(177, 41, 160, 27);
										painelEnderecoCliente.add(textField);
										textField.setColumns(10);
										
										JLabel lblEmail = new JLabel("Email:");
										lblEmail.setBounds(10, 79, 46, 14);
										painelEnderecoCliente.add(lblEmail);
										
										txtemail = new JTextField();
										txtemail.setBounds(10, 93, 137, 27);
										painelEnderecoCliente.add(txtemail);
										txtemail.setColumns(10);
										
										JLabel lblTelefone = new JLabel("Telefone:");
										lblTelefone.setBounds(177, 79, 46, 14);
										painelEnderecoCliente.add(lblTelefone);
										
										txtTelefone = new JTextField();
										txtTelefone.setBounds(177, 93, 160, 27);
										painelEnderecoCliente.add(txtTelefone);
										txtTelefone.setColumns(10);
										
										lblLogradouro = new JLabel("Logradouro:");
										lblLogradouro.setBounds(10, 131, 66, 14);
										painelEnderecoCliente.add(lblLogradouro);
										
										txtLogra = new JTextField();
										txtLogra.setBounds(10, 151, 223, 27);
										painelEnderecoCliente.add(txtLogra);
										txtLogra.setColumns(10);
										
										JPanel panelRsultCliente = new JPanel();
										panelRsultCliente.setBackground(new Color(240, 240, 240));
										panelRsultCliente.setBorder(new TitledBorder(null, "Resultado do Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
										panelRsultCliente.setBounds(408, 264, 151, 196);
										DetalhesCliente.add(panelRsultCliente);
										panelRsultCliente.setLayout(null);
										
										//* Imc
										lblImc = new JLabel("IMC:", JLabel.RIGHT);
										lblImc.setBounds(10, 44, 47, 20);
										panelRsultCliente.add(lblImc);
										
										
										
										//** TMB
										
										lblTmb = new JLabel("TMB:", JLabel.RIGHT);
										lblTmb.setBounds(10, 90, 47, 20);
										panelRsultCliente.add(lblTmb);
										
										lblTmbL = new JLabel("...", JLabel.LEFT);
										lblTmbL.setBounds(67, 90, 74, 20);
										panelRsultCliente.add(lblTmbL);
										
										
										//** FCM
										lblFcm = new JLabel("FCM:", JLabel.RIGHT);
										lblFcm.setBounds(10, 132, 47, 20);
										panelRsultCliente.add(lblFcm);
										
										lblFcmL = new JLabel("...", JLabel.LEFT);
										lblFcmL.setBounds(67, 132, 110, 20);
										panelRsultCliente.add(lblFcmL);
										
										lblImcl = new JLabel("...");
										lblImcl.setBounds(67, 44, 76, 20);
										panelRsultCliente.add(lblImcl);
		
		setVisible(true);

	}
}
