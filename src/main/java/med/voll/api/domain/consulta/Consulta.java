package med.voll.api.domain.consulta;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.paciente.Paciente;

import java.time.LocalDateTime;

    @Table(name = "consultas")
    @Entity(name = "Consulta")
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of = "id")
    public class Consulta {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "medico_id")
        private Medico medico;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "paciente_id")
        private Paciente paciente;

        private LocalDateTime data;

        @Column(name = "motivo_cancelamento")
        @Enumerated(EnumType.STRING)
        private MotivoCancelamento motivoCancelamento;

        public void cancelar(@NotNull MotivoCancelamento motivo) {
            this.motivoCancelamento = motivo;
        }

        public Consulta() {
        }

        public Consulta(Long id, Medico medico, Paciente paciente, LocalDateTime data, MotivoCancelamento motivoCancelamento) {
            this.id = id;
            this.medico = medico;
            this.paciente = paciente;
            this.data = data;
            this.motivoCancelamento = motivoCancelamento;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Medico getMedico() {
            return medico;
        }

        public void setMedico(Medico medico) {
            this.medico = medico;
        }

        public Paciente getPaciente() {
            return paciente;
        }

        public void setPaciente(Paciente paciente) {
            this.paciente = paciente;
        }

        public LocalDateTime getData() {
            return data;
        }

        public void setData(LocalDateTime data) {
            this.data = data;
        }

        public MotivoCancelamento getMotivoCancelamento() {
            return motivoCancelamento;
        }

        public void setMotivoCancelamento(MotivoCancelamento motivoCancelamento) {
            this.motivoCancelamento = motivoCancelamento;
        }
    }
