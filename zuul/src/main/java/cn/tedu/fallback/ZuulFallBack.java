package cn.tedu.fallback;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.zuul.filters.route.ZuulFallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

@Component
public class ZuulFallBack implements ZuulFallbackProvider{

	@Override  //返回的路由,通用
	public String getRoute() {		
		return "I Don't Really Care About!!!!!";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		// TODO Auto-generated method stub
		return new ClientHttpResponse() {
			
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
				return headers;

			}
			
			@Override
			public InputStream getBody() throws IOException {
				// TODO Auto-generated method stub
				return new ByteArrayInputStream
						(("fallback "+ZuulFallBack.this.getRoute()).getBytes());
			}
			
			@Override
			public String getStatusText() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.getReasonPhrase();
			}
			
			@Override
			public HttpStatus getStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST;
			}
			
			@Override
			public int getRawStatusCode() throws IOException {
				// TODO Auto-generated method stub
				return HttpStatus.BAD_REQUEST.value();
			}
			
			@Override
			public void close() {
				// TODO Auto-generated method stub
				
			}
		};
	}
	
}
