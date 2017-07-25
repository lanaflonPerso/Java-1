package betting.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Entity
@Table(name = "result_predictions")
public class ResultPrediction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_prediction_id")
    private long id;

    @Basic
    private String prediction;

    public ResultPrediction() {
    }

    public ResultPrediction(String prediction) {
        this.prediction = prediction;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrediction() {
        return this.prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
