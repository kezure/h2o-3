package hex.schemas;

import hex.genmodel.algos.h2osvm.KernelType;
import hex.svm.SVM;
import hex.svm.SVMModel;
import water.api.API;
import water.api.schemas3.ModelParametersSchemaV3;

public class SVMV3 extends ModelBuilderSchema<SVM, SVMV3, SVMV3.SVMParametersV3> {

  public static final class SVMParametersV3 extends ModelParametersSchemaV3<SVMModel.SVMParameters, SVMV3.SVMParametersV3> {
    public static final String[] fields = new String[]{
            "model_id",
            "training_frame",
            "validation_frame",
            "response_column",
            "ignored_columns",
            "ignore_const_cols",
            "hyper_param",
            "kernel_type",
            "gamma",
            "rank_ratio",
            "positive_weight",
            "negative_weight",
            "sv_threshold",
            "fact_threshold",
            "feasible_threshold",
            "surrogate_gap_threshold",
            "mu_factor",
            "max_iterations",
            "seed",
    };

    @API(help = "Penalty parameter C of the error term", gridable = true)
    public double hyper_param;

    @API(help = "Type of used kernel", values = {"gaussian"})
    public KernelType kernel_type;

    @API(help = "Coefficient of the kernel (currently RBF gamma for gaussian kernel, -1 means 1/#features)", gridable = true)
    public double gamma;

    @API(help = "Desired rank of the ICF matrix expressed as an ration of number of input rows (-1 means use sqrt(#rows)).")
    public double rank_ratio;

    @API(help = "Weight of positive (+1) class of observations")
    public double positive_weight;

    @API(help = "Weight of positive (-1) class of observations")
    public double negative_weight;

    @API(help = "Threshold for accepting a candidate observation into the set of support vectors", level = API.Level.secondary)
    public double sv_threshold;

    @API(help = "Maximum number of iteration of the algorithm", level = API.Level.secondary)
    public int max_iterations;
    
    @API(help = "Convergence threshold of the Incomplete Cholesky Factorization (ICF)", level = API.Level.expert)
    public double fact_threshold;

    @API(help = "Convergence threshold for primal-dual residuals in the IPM iteration", level = API.Level.expert)
    public double feasible_threshold;

    @API(help = "Feasibility criterion of the surrogate duality gap (eta)", level = API.Level.expert)
    public double surrogate_gap_threshold;

    @API(help = "Increasing factor mu", level = API.Level.expert)
    public double mu_factor;

    @API(help = "Seed for pseudo random number generator (if applicable)", gridable = true)
    public long seed;

  }

}
