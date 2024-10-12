package project.tool.management.exceptions;

import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * This class used to handle all error response related to GraphQL
 * */
@Component
public class GraphQLExceptionHandler extends DataFetcherExceptionResolverAdapter {

    @Override
    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        // Handle DuplicateEmailException specifically
        if (ex instanceof DuplicateEmailHandler) {
            return GraphqlErrorBuilder.newError()
                    .message(ex.getMessage())
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        }

        // Handle other exceptions with a generic error message
        return GraphqlErrorBuilder.newError()
                .message("An unexpected error occurred")
                .build();
    }
}
