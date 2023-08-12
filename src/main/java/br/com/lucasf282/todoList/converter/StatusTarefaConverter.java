package br.com.lucasf282.todoList.converter;

import br.com.lucasf282.todoList.enums.StatusTarefa;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class StatusTarefaConverter implements AttributeConverter<StatusTarefa, Long> {

    @Override
    public Long convertToDatabaseColumn(StatusTarefa status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public StatusTarefa convertToEntityAttribute(Long id) {
        return StatusTarefa.of(id);
    }
}
