package fr.aceko.infrastructure;

import fr.aceko.domain.Maison;
import fr.aceko.domain.MaisonDao;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

@Component
public class PostgresMaisonDao implements MaisonDao {
    @Override
    public void createMaison(Maison maison) {
        String query = """
                INSERT INTO maison (nom, prix, adresse, caution) values (?, ?, ?, ?)
                """;

        try (PreparedStatement statement = PostgresConnection.getInstance().prepareStatement(query)) {
            statement.setString(1, maison.getNom());
            statement.setDouble(2, maison.getPrix());
            statement.setString(3, maison.getAdresse());
            statement.setDouble(4, maison.getPrix());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Une erreur est survenue lors de la création d'une maison.");
        }
    }

    @Override
    public int count() {
        String query = "SELECT COUNT(*) AS total FROM maison";
        int total = 0;
        try (PreparedStatement statement = PostgresConnection.getInstance().prepareStatement(query)) {
            ResultSet result = statement.executeQuery();
            if(result.next()) total = result.getInt("total");
        } catch (SQLException e) {
            System.out.println("Une erreur est survenue lors de la création d'une maison.");
        }
        return total;
    }

    @Override
    public boolean exists(String nom) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Maison> listAll() {
        return null;
    }

    @Override
    public Maison findById(Long maisonId) {
        return null;
    }
}
