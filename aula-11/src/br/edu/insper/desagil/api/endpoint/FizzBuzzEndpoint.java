package br.edu.insper.desagil.api.endpoint;

import br.edu.insper.desagil.api.http.Args;
import br.edu.insper.desagil.api.http.Endpoint;

public class FizzBuzzEndpoint extends Endpoint<String>{
	public FizzBuzzEndpoint() {
		super("/fizzbuzz");
	}
	
	@Override
	public String get(Args args) {
		int n = args.getInt("n");
		if (n % 3 == 0 && n % 5 == 0) {
			return "FizzBuzz";
		} else if (n % 3 == 0) {
			return "Fizz";
		} else if (n % 5 == 0) {
			return "Buzz";
		} else {
			return Integer.toString(n);
		}
	}
}
