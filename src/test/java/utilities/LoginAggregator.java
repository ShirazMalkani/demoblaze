package utilities;

import bo.LoginBo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;

public class LoginAggregator implements ArgumentsAggregator {
    @Override
    public LoginBo aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        return new LoginBo(arguments.getString(0),
                arguments.getString(1),
                arguments.getString(2),
                arguments.getString(3),
                arguments.getString(4),
                arguments.getString(5));
    }
}