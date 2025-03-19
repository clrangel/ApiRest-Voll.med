package med.voll.api.domain.paciente;

public record DadosListagemPaciente(Long Id, String nome, String email, String cpf, String telefone ) {

    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getCpf(), paciente.getTelefone());
    }
}
