package tp.mapper;

import java.sql.SQLException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class SQLExceptionMapper implements ExceptionMapper<SQLException> {

	@Override
	public Response toResponse(final SQLException exception) {
		return Response.status(Response.Status.BAD_REQUEST)
				.entity(prepareMessage(exception)).type("text/plain")
				.build();
	}

	private String prepareMessage(SQLException e) {
		StringBuilder msg = new StringBuilder();
		msg.append(e.getErrorCode() + ": " + e.getCause());
		return msg.toString();
	}
}
