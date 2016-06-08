package ar.edu.TPPOI;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Horario {
	private DayOfWeek diaDeLaSemana;
	private LocalTime horaInicio;
	private LocalTime horaFin;

	public Horario(DayOfWeek unDiaDeLaSemana, LocalTime unaHoraInicio, LocalTime unaHoraFin) {
		this.diaDeLaSemana = unDiaDeLaSemana;
		this.horaInicio = unaHoraInicio;
		this.horaFin = unaHoraFin;
	}

	public boolean estaEnMiHorario(LocalDateTime unaFechaHora) {
		DayOfWeek unDiaDeSemana = unaFechaHora.toLocalDate().getDayOfWeek();
		LocalTime horaDelDia = unaFechaHora.toLocalTime();

		return ((this.diaDeLaSemana == unDiaDeSemana)
				&& (horaDelDia.isAfter(horaInicio) && horaDelDia.isBefore(horaFin)));
	}

}
