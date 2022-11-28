package br.com.etechoracio.hospital;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.etechoracio.hospital.entity.Cirurgia;
import br.com.etechoracio.hospital.entity.Consulta;
import br.com.etechoracio.hospital.entity.Convenio;
import br.com.etechoracio.hospital.entity.Enfermeiro;
import br.com.etechoracio.hospital.entity.Exame;
import br.com.etechoracio.hospital.entity.HistoricoConsulta;
import br.com.etechoracio.hospital.entity.Hospital;
import br.com.etechoracio.hospital.entity.Internacao;
import br.com.etechoracio.hospital.entity.Medico;
import br.com.etechoracio.hospital.entity.Paciente;
import br.com.etechoracio.hospital.entity.Prontuario;
import br.com.etechoracio.hospital.entity.Remedio;
import br.com.etechoracio.hospital.enums.StatusFuncionarioEnum;
import br.com.etechoracio.hospital.enums.StatusMedicoEnum;
import br.com.etechoracio.hospital.enums.TipoCirurgiaEnum;
import br.com.etechoracio.hospital.enums.TipoDoencaEnum;
import br.com.etechoracio.hospital.enums.TipoExameEnum;
import br.com.etechoracio.hospital.enums.TipoInternacaoEnum;
import br.com.etechoracio.hospital.repository.CirurgiaRepository;
import br.com.etechoracio.hospital.repository.ConsultaRepository;
import br.com.etechoracio.hospital.repository.ConvenioRepository;
import br.com.etechoracio.hospital.repository.EnfermeiroRepository;
import br.com.etechoracio.hospital.repository.ExameRepository;
import br.com.etechoracio.hospital.repository.HistoricoConsultaRepository;
import br.com.etechoracio.hospital.repository.HospitalRepository;
import br.com.etechoracio.hospital.repository.InternacaoRepository;
import br.com.etechoracio.hospital.repository.MedicoRepository;
import br.com.etechoracio.hospital.repository.PacienteRepository;
import br.com.etechoracio.hospital.repository.ProntuarioRepository;
import br.com.etechoracio.hospital.repository.RemedioRepository;

@SpringBootApplication
public class HospitalApplication implements CommandLineRunner {

	@Autowired
	private CirurgiaRepository cirurgiaRepository;

	@Autowired
	private ConsultaRepository consultaRepository;

	@Autowired
	private ConvenioRepository convenioRepository;

	@Autowired
	private EnfermeiroRepository enfermeiroRepository;

	@Autowired
	private ExameRepository exameRepository;

	@Autowired
	private HistoricoConsultaRepository historicoConsultaRepository;

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private InternacaoRepository internacaoRepository;

	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private ProntuarioRepository prontuarioRepository;

	@Autowired
	private RemedioRepository remedioRepository;

	@Override
	public void run(String... args) throws Exception {
		Hospital hospital = Hospital.builder().endereco("Vila Paiva").nome("Presidente").build();
		hospitalRepository.save(hospital);

		Convenio convenio = Convenio.builder().valor(1000).nome("Notredame").build();
		convenioRepository.save(convenio);

		Paciente paciente = Paciente.builder().cpf("12345678901").convenio(convenio).dataNascimento(LocalDate.now()).endereco("Rua das Andorinhas, 314").telefone("123456789").nome("Guilherme").peso(75).altura(1).build();
		pacienteRepository.save(paciente);

		Medico medico = Medico.builder().hospital(hospital).endereco("Rua rei da Peste").dataNascimento(LocalDate.now()).nome("Reuledo").cpf("12345678901").status(StatusMedicoEnum.ATIVO).salario(3000).telefone("123456788").build();
		medicoRepository.save(medico);

		Prontuario prontuario = Prontuario.builder().observacao("null").dataEmissao(LocalDateTime.now()).historicoFamiliar("Muita coisa").doenca(TipoDoencaEnum.GENETICA).medico(medico).hospital(hospital).paciente(paciente).build();
		prontuarioRepository.save(prontuario);

		Cirurgia cirurgia = Cirurgia.builder().dataHora(LocalDateTime.now()).tipo(TipoCirurgiaEnum.CURATIVA).prontuario(prontuario).build();
		cirurgiaRepository.save(cirurgia);

		Internacao internacao = Internacao.builder().dataHora(LocalDateTime.now()).tipo(TipoInternacaoEnum.INVOLUNTARIA).prontuario(prontuario).build();
		internacaoRepository.save(internacao);

		HistoricoConsulta historicoConsulta = HistoricoConsulta.builder().assinatura("Medico").prescricao("Uma prescrição aí").prontuario(prontuario).build();
		historicoConsultaRepository.save(historicoConsulta);

		Remedio remedio = Remedio.builder().dataValidade(LocalDate.now()).dataFabricacao(LocalDate.now()).nome("NordVPN").fabricante("Fabricalis").historicoConsulta(historicoConsulta).build();
		remedioRepository.save(remedio);

		Exame exame = Exame.builder().dataHora(LocalDateTime.now()).nome("Exame Legal :D").tipo(TipoExameEnum.LABORATORIAL).prontuario(prontuario).build();
		exameRepository.save(exame);

		Enfermeiro enfermeiro = Enfermeiro.builder().endereco("Normies Location").dataNascimento(LocalDate.now()).nome("Helen").cpf("12345678802").status(StatusFuncionarioEnum.INATIVO).salario(2000).telefone("12345678901").hospital(hospital).cirurgia(cirurgia).build();
		enfermeiroRepository.save(enfermeiro);

		Consulta consulta = Consulta.builder().data(LocalDate.now()).hora(LocalTime.now()).medico(medico).prontuario(prontuario).build();
		consultaRepository.save(consulta);
	}

	public static void main(String[] args) {
		SpringApplication.run(HospitalApplication.class, args);
	}
}
