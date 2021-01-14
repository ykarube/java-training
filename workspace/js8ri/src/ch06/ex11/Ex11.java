package ch06.ex11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.PasswordAuthentication;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex11 {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final String PASS = "secret";

		 CompletableFuture<Void> f = repeat(
			() -> {
				System.out.println("please input password:");

				BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
				String passwd;
				try {
					passwd = reader.readLine();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
				return new PasswordAuthentication("default", passwd.toCharArray());
			},
			passwdAuth -> {
				try {
					Thread.sleep(1_000);
				} catch (Exception e) {
					throw new RuntimeException(e);
				}

				boolean r = String.valueOf(passwdAuth.getPassword()).equals(PASS);
				if(!r) {
					System.out.println("bad password");
				}
				return r;
			}
		).thenAccept(passwdAuth -> {
			System.out.println("userName:" + passwdAuth.getUserName() + ", password:" + String.valueOf(passwdAuth.getPassword()));
		}).exceptionally(th -> {
			th.printStackTrace();
			return null;
		});

		f.join();
	}

	public static <T> CompletableFuture<T> repeat(
		Supplier<T> action, Predicate<T> until)
	{
		return CompletableFuture.supplyAsync(action).thenComposeAsync(t -> {
			if(until.test(t)){
				return CompletableFuture.completedFuture(t);
			} else {
				return repeat(action, until);
			}
		});
	}
}
