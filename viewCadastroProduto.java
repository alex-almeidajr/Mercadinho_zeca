package cadastro.view;
import java.util.Date;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import cadastro.dao.CadastroDAO;
import cadastro.model.CadastroProduto;
import cadastro.view.util.LimitaCaracteres;
import cadastro.view.util.LimitaCaracteres.TipoEntrada;
import cadastro.view.util.MonetarioDocument;
import javax.swing.JTable;
import javax.swing.JComboBox;


public class viewCadastroProduto {

	public JFrame frmCadastroDeProduto;
	public static JTextField txtCodigo;
	public static JTextField txtCodigoBarra;
	public static JTextField txtDescricao;
	public static JTextField txtGrupo;
	public static JTextField txtFornecedor;
	public static JTextField txtMarca;
	public static JTextField txtPrecoVenda;
	public static JTextField txtDataCadastro;
	public static JTextField txtUnidadeMedida;
	public static JTextField txtEstoque;
	public static JCheckBox cbAtivo;
	public static JTable tableGrupo;
	public static JTable tableFornecedor;
	private JTextField txtConsultar;
	
	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			//public void run() {
				try {
					viewCadastroProduto window = new viewCadastroProduto();
					window.frmCadastroDeProduto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		//});		


	/**
	 * Create the application.
	 * @throws ParseException 
	 */
	public viewCadastroProduto() throws ParseException {
		initialize(); 
	
		txtCodigoBarra.setDocument(new LimitaCaracteres(13, TipoEntrada.NUMEROINTEIRO));
		txtDescricao.setDocument(new LimitaCaracteres(45, TipoEntrada.ALFANUMERICO));
		txtMarca.setDocument(new LimitaCaracteres(20, TipoEntrada.NOME));
		//txtPrecoVenda.setDocument(new LimitaCaracteres(10, TipoEntrada.NUMERODECIMAL));
		txtUnidadeMedida.setDocument(new LimitaCaracteres(5, TipoEntrada.NOME));
		txtEstoque.setDocument(new LimitaCaracteres(10, TipoEntrada.NUMEROINTEIRO));
		
		JButton btnBuscaGrupo = new javax.swing.JButton("...");
		//btnBuscaGrupo.setEnabled(false);
		btnBuscaGrupo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableGrupo.setVisible(true);
			}
		});
		//btnBuscaGrupo.setIcon(new ImageIcon("C:\\Users\\alexjr\\Documents\\NetBeansProjects\\mercadinho_zeca\\src\\icones\\icons8-pesquisar-64.png"));
		btnBuscaGrupo.setBounds(324, 82, 18, 18);
		frmCadastroDeProduto.getContentPane().add(btnBuscaGrupo);
		
		JButton btnBuscaFornecedor = new javax.swing.JButton("...");
		//btnBuscaFornecedor.setEnabled(false);
		btnBuscaFornecedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableFornecedor.setVisible(true);
				
			}
		});
		//btnBuscaFornecedor.setIcon(new ImageIcon("C:\\Users\\alexjr\\Documents\\NetBeansProjects\\mercadinho_zeca\\src\\icones\\icons8-pesquisar-64.png"));
		btnBuscaFornecedor.setBounds(324, 118, 18, 18);
		frmCadastroDeProduto.getContentPane().add(btnBuscaFornecedor);
		
		tableGrupo = new JTable();
		tableGrupo.setVisible(false);
		tableGrupo.setBounds(130, 100, 410, 115);
		frmCadastroDeProduto.getContentPane().add(tableGrupo);
		
		tableFornecedor = new JTable();
		tableFornecedor.setVisible(false);
		tableFornecedor.setBounds(130, 136, 410, 115);
		frmCadastroDeProduto.getContentPane().add(tableFornecedor);
		
		
		
		  JComboBox cbTipoConsultar = new JComboBox();
		  cbTipoConsultar.addItem("Código"); //cbTipoConsultar.addItem("Descrição");
		  cbTipoConsultar.setBounds(10, 265, 86, 21);
		  frmCadastroDeProduto.getContentPane().add(cbTipoConsultar);
		 
		
		txtConsultar = new JTextField();
		txtConsultar.setColumns(10);
		txtConsultar.setBounds(108, 264, 241, 22);
		frmCadastroDeProduto.getContentPane().add(txtConsultar);
		
		JButton btnCancelar = new JButton("< Anterior");
		btnCancelar.setBounds(488, 265, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnCancelar);
	}


	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmCadastroDeProduto = new JFrame();
		frmCadastroDeProduto.setTitle("Cadastro de produto");
		frmCadastroDeProduto.setBounds(100, 100, 620, 340);
		frmCadastroDeProduto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastroDeProduto.getContentPane().setLayout(null);
		
		JButton btnPrximo = new JButton("Pr\u00F3ximo >");
		btnPrximo.setBounds(488, 231, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnPrximo);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(10, 13, 46, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel);
		
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		txtCodigo.setBounds(130, 11, 86, 20);
		frmCadastroDeProduto.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(4);
		
		JLabel lblNewLabel_1 = new JLabel("C\u00F3digo de barras");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(228, 12, 117, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_1);
		
		txtCodigoBarra = new JTextField();
		txtCodigoBarra.setEditable(false);
		txtCodigoBarra.setBounds(345, 11, 108, 20);
		frmCadastroDeProduto.getContentPane().add(txtCodigoBarra);
		txtCodigoBarra.setColumns(1);
		
		JLabel lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(10, 47, 61, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_2);
		
		txtDescricao = new JTextField();
		txtDescricao.setEditable(false);
		txtDescricao.setColumns(10);
		txtDescricao.setBounds(130, 45, 323, 20);
		frmCadastroDeProduto.getContentPane().add(txtDescricao);
		
		JLabel lblNewLabel_3 = new JLabel("Grupo");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(10, 83, 46, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_3);
		
		txtGrupo = new JTextField();
		txtGrupo.setEditable(false);
		txtGrupo.setBounds(130, 80, 185, 20);
		frmCadastroDeProduto.getContentPane().add(txtGrupo);
		txtGrupo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Fornecedor");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(10, 119, 71, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_4);
		
		txtFornecedor = new JTextField();
		txtFornecedor.setEditable(false);
		txtFornecedor.setColumns(10);
		txtFornecedor.setBounds(130, 116, 185, 20);
		frmCadastroDeProduto.getContentPane().add(txtFornecedor);
		
		JLabel lblNewLabel_4_1 = new JLabel("Marca");
		lblNewLabel_4_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4_1.setBounds(10, 157, 55, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_4_1);
		
		txtMarca = new JTextField();
		txtMarca.setEditable(false);
		txtMarca.setColumns(10);
		txtMarca.setBounds(130, 153, 185, 20);
		frmCadastroDeProduto.getContentPane().add(txtMarca);
		
		JLabel lblNewLabel_3_1 = new JLabel("Pre\u00E7o de venda");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1.setBounds(10, 230, 110, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_3_1);
		
		txtPrecoVenda = new JTextField(8); 
		txtPrecoVenda .setDocument(new MonetarioDocument());
		txtPrecoVenda.setEditable(false);
		txtPrecoVenda.setColumns(10);
		txtPrecoVenda.setBounds(130, 228, 86, 20);
		frmCadastroDeProduto.getContentPane().add(txtPrecoVenda);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Data de cadastro");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_1.setBounds(250, 231, 107, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_3_1_1);
		
		txtDataCadastro = new JTextField();
		txtDataCadastro.setEditable(false);
		txtDataCadastro.setColumns(10);
		txtDataCadastro.setBounds(367, 228, 86, 20);
		frmCadastroDeProduto.getContentPane().add(txtDataCadastro);
		
		JCheckBox cbAtivo = new JCheckBox("Ativo");
		cbAtivo.setEnabled(false);
		cbAtivo.setSelected(true);
		cbAtivo.setBounds(398, 149, 55, 23);
		frmCadastroDeProduto.getContentPane().add(cbAtivo);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigoBarra.setEditable(true);
				txtDescricao.setEditable(true);
				cbAtivo.setEnabled(true);
				txtMarca.setEditable(true);
				txtPrecoVenda.setEditable(true);
				txtUnidadeMedida.setEditable(true);
				txtEstoque.setEditable(true);
			}
		});
		
		btnIncluir.setBounds(488, 13, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnIncluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(488, 51, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(488, 87, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnExcluir);
		
		JButton btnConsultar = new javax.swing.JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigoConsulta = Integer.parseInt(txtConsultar.getText());
				CadastroDAO cadastroDAO = new CadastroDAO();
				CadastroProduto cadastro = cadastroDAO.consulta(codigoConsulta);
				
				if (cadastro == null) {
					JOptionPane.showMessageDialog(btnConsultar, "Cadastro não encontrado!");
				}
				else {
					
					txtCodigo.setText(Integer.toString(cadastro.getCodigo()));
					txtCodigoBarra.setText(cadastro.getCodigo_barras());
					txtDescricao.setText(cadastro.getDescricao());
					txtGrupo.setText(Integer.toString(cadastro.getGrupo()));
					txtFornecedor.setText(Integer.toString(cadastro.getFornecedor()));
					txtMarca.setText(cadastro.getMarca());
					cbAtivo.setSelected(cadastro.isAtivo());
					txtUnidadeMedida.setText(cadastro.getUnidade_medida());
					txtEstoque.setText(Integer.toString(cadastro.getEstoque()));
					txtPrecoVenda.setText(Double.toString(cadastro.getPreco_venda()));
					
			        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			        String dataFormatada = dateFormat.format(cadastro.getData_cadastro());
					
					txtDataCadastro.setText(dataFormatada);
				}
			}
		});
		
		
		btnConsultar.setBounds(359, 264, 94, 23);
		frmCadastroDeProduto.getContentPane().add(btnConsultar);
		
		JButton btnSalvar = new javax.swing.JButton("Salvar");
		//btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CadastroProduto cadastro = new CadastroProduto();	
				
				double valorPrecoVenda = Double.parseDouble(txtPrecoVenda.getText());
				int valorEstoque = Integer.parseInt(txtEstoque.getText());			
				
				cadastro.setDescricao(txtDescricao.getText());
				cadastro.setCodigo_barras(txtCodigoBarra.getText());
				cadastro.setGrupo(1);
				cadastro.setFornecedor(1);
				cadastro.setAtivo(cbAtivo.isSelected());
				cadastro.setMarca(txtMarca.getText());
				cadastro.setPreco_venda (valorPrecoVenda);
				cadastro.setData_cadastro(new Date());
				cadastro.setEstoque(valorEstoque);
				cadastro.setUnidade_medida(txtUnidadeMedida.getText());
				CadastroDAO.incluir(cadastro);
			}
		});
		btnSalvar.setBounds(488, 124, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnSalvar);
		
		JButton btnCancelar = new javax.swing.JButton("Cancelar");
		//btnCancelar.setEnabled(false);
		btnCancelar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtCodigo.setText("");
				txtCodigo.setEditable(false);
				txtDescricao.setText("");
				txtDescricao.setEditable(false);
				txtCodigoBarra.setText("");
				txtCodigoBarra.setEditable(false);
				txtGrupo.setText("");
				txtGrupo.setEditable(false);
				tableGrupo.setVisible(false);
				txtFornecedor.setText("");
				txtFornecedor.setEditable(false);
				tableFornecedor.setVisible(false);
				txtEstoque.setText("");
				txtEstoque.setEditable(false);
				txtDataCadastro.setText("");
				txtDataCadastro.setEditable(false);
				txtMarca.setText("");
				txtMarca.setEditable(false);
				txtUnidadeMedida.setText("");
				txtUnidadeMedida.setEditable(false);
				txtPrecoVenda.setText("");
				txtPrecoVenda.setEditable(false);
				btnCancelar.setEnabled(false);
				btnSalvar.setEnabled(false);
				
			}
		});
		btnCancelar.setBounds(488, 158, 101, 23);
		frmCadastroDeProduto.getContentPane().add(btnCancelar);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(470, 0, 1, 300);
		frmCadastroDeProduto.getContentPane().add(separator);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("Unidade medida");
		lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_2.setBounds(10, 192, 110, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_3_1_2);
		
		txtUnidadeMedida = new JTextField();
		txtUnidadeMedida.setEditable(false);
		txtUnidadeMedida.setColumns(10);
		txtUnidadeMedida.setBounds(130, 190, 86, 20);
		frmCadastroDeProduto.getContentPane().add(txtUnidadeMedida);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Estoque");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_1_1_1.setBounds(293, 193, 64, 14);
		frmCadastroDeProduto.getContentPane().add(lblNewLabel_3_1_1_1);
		
		txtEstoque = new JTextField();
		txtEstoque.setEditable(false);
		txtEstoque.setColumns(10);
		txtEstoque.setBounds(367, 190, 86, 20);
		frmCadastroDeProduto.getContentPane().add(txtEstoque);
	}	
}