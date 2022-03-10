package com.core.java.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class BankBackEndConnect {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService service = Executors.newFixedThreadPool(2);

		HashMap<String, String> requestMap = new HashMap<String, String>();

		List<HostCallNode> listHost = new ArrayList<HostCallNode>();
		listHost.add(new HostCallNode("PMR", requestMap));
		listHost.add(new HostCallNode("ADV", requestMap));

		Future<HashMap<String, String>> future = service.submit(new HostCallNode("PMR", requestMap));
		Future<HashMap<String, String>> future2 = service.submit(new HostCallNode("ADV", requestMap));
		
		/*
		 * CompletableFuture<HashMap<String, String>>
		 * cf1=(CompletableFuture<HashMap<String, String>>) service.submit(new
		 * HostCallNode("PMR", requestMap)); CompletableFuture<HashMap<String, String>>
		 * cf12=(CompletableFuture<HashMap<String, String>>) service.submit(new
		 * HostCallNode("ADV", requestMap));
		 */

		// Future<List<HostCallNode>> future1= (Future<List<HostCallNode>>)
		// service.invokeAll(listHost);

		//Thread.sleep(2000);
		List<Future<HashMap<String, String>>> future1 = service.invokeAll(listHost);

		for (Future<HashMap<String, String>> fut : future1) {

			try {

				System.out.println(" Customer Name " + fut.get().get("Cust_Name"));
				System.out.println(" Customer Name " + fut.get().get("Cust_Type"));

			} catch (Exception e) {
				System.out.println("PMR not available");
			}

		}

		/*
		 * if (!future.isDone() && !future2.isDone()) {
		 * 
		 * try { System.out.println(" Customer Name " + future.get().get("Cust_Name"));
		 * System.out.println(" Customer Name " + future.get().get("Cust_Type"));
		 * 
		 * } catch (Exception e) { System.out.println("PMR not available"); }
		 * 
		 * 
		 * System.out.println("SECOND FUTURE ");
		 * 
		 * System.out.println(" Customer Name " + future2.get().get("Cust_Name"));
		 * System.out.println(" Customer Type " + future2.get().get("Cust_Type")); }
		 * 
		 * else { System.out.println("Not proccessed"); }
		 */

	}
}
