package com.nttdata.bootcamp.msgateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class MsGatewayPostFilter extends AbstractGatewayFilterFactory<MsGatewayPostFilter.Config> {
	
	public MsGatewayPostFilter() {
		super(Config.class);
	}
	
	@Override
	public GatewayFilter apply(Config config) {
		System.out.println("inside MsGatewayPostFilter.apply method...");
		
		return(exchange, chain)->{
			return chain.filter(exchange).then(Mono.fromRunnable(()->{
				ServerHttpResponse response = exchange.getResponse();
				HttpHeaders headers = response.getHeaders();
				headers.forEach((k,v)->{
					System.out.println(k + " : " + v);
				});
			}));
		};
	}
	
	public static class Config {
		private String name;
		
		public String getName() {
			return this.name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
	}

}