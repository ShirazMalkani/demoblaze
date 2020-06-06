package utilities;

import bo.RegistrationBo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class RegistrationAggregator implements ArgumentsAggregator {
    @Override
    public RegistrationBo aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        return new RegistrationBo(arguments.getString(0),
                arguments.getString(1),
                arguments.getString(2),
                arguments.getString(3),
                arguments.getString(4),
                arguments.getString(5),
                arguments.getString(6),
                arguments.getString(7),
                arguments.getString(8));
    }
}
