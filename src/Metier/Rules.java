package Metier;
import Vue.GUI;


public class Rules {

		private Environnement env;
		private GUI theUI;
		Reconstruct thread;

		public Rules(int length,int height,GUI theUI) {
			super();
			this.theUI=theUI;
			env=new Environnement(length, height);
		}
		
		public Rules(Environnement env) {
			super();
			this.env = env;
		}

		/**
		 * @return the env
		 */
		public Environnement getEnv() {
			return env;
		}

		/**
		 * @param env the env to set
		 */
		public void setEnv(Environnement env) {
			this.env = env;
		}
		
		public void iterer(int nbCycles)
		{
			thread=new Reconstruct(env,theUI,nbCycles);
			((Thread)thread).start();
			
		}
		
		
		
		
}
