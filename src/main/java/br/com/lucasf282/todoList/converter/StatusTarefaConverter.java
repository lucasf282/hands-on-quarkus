package br.com.lucasf282.todoList.converter;

import br.com.lucasf282.todoList.enums.StatusTarefaEnum;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class StatusTarefaConverter implements AttributeConverter<StatusTarefaEnum, Long> {

    @Override
    public Long convertToDatabaseColumn(StatusTarefaEnum status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public StatusTarefaEnum convertToEntityAttribute(Long id) {
        return StatusTarefaEnum.of(id);
    }
}
